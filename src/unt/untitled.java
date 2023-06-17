package unt;

import java.applet.Applet;
import java.awt.*;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.PlatformGeometry;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Vector;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

public class untitled extends Applet implements KeyListener{
    //inicjacja zmiennych używanych w programie
    BranchGroup scena;
    BranchGroup wezel_scena = new BranchGroup();
    BranchGroup wezel_2 = new BranchGroup();
    BranchGroup wezel_3_kulka = new BranchGroup();
    Alpha alpha_animacja;
    Alpha alpha_animacja_kulka;
    RotationInterpolator obracacz;
    RotationInterpolator obracacz_kulka;
    Transform3D przesuniecie_ramie1 = new Transform3D();
    TransformGroup pozycja_ramie = new TransformGroup();
    Transform3D przesuniecie_ramie2 = new Transform3D();
    TransformGroup pozycja_ramie2 = new TransformGroup();

    //transformacje kuleczki
    Transform3D przesuniecie_ramie1_kulka = new Transform3D();
    TransformGroup pozycja_ramie_kulka = new TransformGroup();
    Transform3D przesuniecie_ramie2_kulka = new Transform3D();
    TransformGroup pozycja_ramie2_kulka = new TransformGroup();
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3D = new Canvas3D(config);
    SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
    Vector3f domyslna_kamera = new Vector3f(0f, 0f, 5f);
    Transform3D kamera = new Transform3D();

    TransformGroup koncowka_p;
    Sphere kuleczka;
    Sphere koncowka;
    int dotyka_b = 0;
    boolean dotyka_latch=false;
    Dotyka dot;
    TransformGroup TG_k;
    Klawisze panel = new Klawisze();
    BranchGroup TG_B = new BranchGroup();
    private Timer zegar = new Timer();
    float a = 0;
    float b = -0.15f;
    float c = 0;
    boolean zablokuj=false;
    float a_startowe_kulki;
    float b_startowe_kulki;
    float c_startowe_kulki;
    int i=0;
    int nagrane_probki=0;
    Vector<Float> a_nagrane = new Vector<>();
    Vector<Float> b_nagrane = new Vector<>();
    Vector<Float> c_nagrane = new Vector<>();
    Vector<Float> a_nagrane_kulka = new Vector<>();
    Vector<Float> b_nagrane_kulka = new Vector<>();
    Vector<Float> c_nagrane_kulka = new Vector<>();
    boolean odtwarzanie = false;
    boolean nagrywanie = false;

    //klasa odpowiedzialna za ruch robota
    class Ruch_robota extends TimerTask{
        @Override
        public void run(){
            //blokada kulki wraz z ramieniem robota
            if(zablokuj)
            {
                obracacz_kulka.setMaximumAngle(a);
                obracacz_kulka.setMinimumAngle(a);
                przesuniecie_ramie1_kulka.setTranslation(new Vector3f(-0.65f, b+0.5f, 0f));
                pozycja_ramie_kulka.setTransform(przesuniecie_ramie1_kulka);
                przesuniecie_ramie2_kulka.setTranslation(new Vector3f(c, 0f, 0f));
                pozycja_ramie2_kulka.setTransform(przesuniecie_ramie2_kulka);
            }
            //praca w trybie normalnym (bez odtwarzania)
            if(!odtwarzanie) {
                obracacz.setMaximumAngle(a);
                obracacz.setMinimumAngle(a);
                przesuniecie_ramie1.setTranslation(new Vector3f(0.3f, b, 0f));
                pozycja_ramie.setTransform(przesuniecie_ramie1);
                przesuniecie_ramie2.setTranslation(new Vector3f(c, 0f, 0f));
                pozycja_ramie2.setTransform(przesuniecie_ramie2);

                //tworzenie wektorów z bieżącym wartościami transformacji - nagrywanie
                if(nagrywanie)
                {
                    a_nagrane.add(a);
                    b_nagrane.add(b);
                    c_nagrane.add(c);

                    //tworzenie analogicznych wektorów dla przemieszczanej kulki, gdy chwycona
                    if(zablokuj)
                    {
                        if (nagrane_probki == 1)
                        {
                            a_startowe_kulki=b;
                            b_startowe_kulki=a;
                            c_startowe_kulki=c;
                        }
                        a_nagrane_kulka.add(a);
                        b_nagrane_kulka.add(b);
                        c_nagrane_kulka.add(c);
                    }
                    else
                    {
                        a_nagrane_kulka.add(0f);
                        b_nagrane_kulka.add(0f);
                        c_nagrane_kulka.add(0f);
                    }

                    nagrane_probki++;
                }
                zegar.cancel();
            }
            else
            {
                obracacz.setMaximumAngle(a_nagrane.get(i));
                obracacz.setMinimumAngle(a_nagrane.get(i));
                przesuniecie_ramie1.setTranslation(new Vector3f(0.3f, b_nagrane.get(i), 0f));
                pozycja_ramie.setTransform(przesuniecie_ramie1);
                przesuniecie_ramie2.setTranslation(new Vector3f(c_nagrane.get(i), 0f, 0f));
                pozycja_ramie2.setTransform(przesuniecie_ramie2);

                //dla kulki

                if(i==1)
                {
                    obracacz_kulka.setMaximumAngle(a_startowe_kulki);
                    obracacz_kulka.setMinimumAngle(a_startowe_kulki);
                    przesuniecie_ramie1_kulka.setTranslation(new Vector3f(-0.85f, b_startowe_kulki+0.05f, 0f));
                    pozycja_ramie_kulka.setTransform(przesuniecie_ramie1_kulka);
                    przesuniecie_ramie2_kulka.setTranslation(new Vector3f(c_startowe_kulki, 0f, 0f));
                    pozycja_ramie2_kulka.setTransform(przesuniecie_ramie2_kulka);
                }

                if(a_nagrane_kulka.get(i) !=0 || b_nagrane_kulka.get(i) !=0 || c_nagrane_kulka.get(i) !=0)
                {
                    obracacz_kulka.setMaximumAngle(a_nagrane_kulka.get(i));
                    obracacz_kulka.setMinimumAngle(a_nagrane_kulka.get(i));
                    przesuniecie_ramie1_kulka.setTranslation(new Vector3f(-0.65f, b_nagrane_kulka.get(i)+0.5f, 0f));
                    pozycja_ramie_kulka.setTransform(przesuniecie_ramie1_kulka);
                    przesuniecie_ramie2_kulka.setTranslation(new Vector3f(c_nagrane_kulka.get(i), 0f, 0f));
                    pozycja_ramie2_kulka.setTransform(przesuniecie_ramie2_kulka);
            }
                i++;
                if (i==nagrane_probki)
                {
                    i=0;
                    odtwarzanie = false;
                    zegar.cancel();
                }

            }
        }
    }
    //funkcja odpowiedzialna za uruchomienie strumienia audio
    public void muzyka(){
        InputStream music;
        try{
            music = new FileInputStream(new File("parostatek.wav"));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    //klasa odpowiedzialna za detekcję kolizji robota
    class Dotyka extends Behavior {
        Sphere shape;
        BranchGroup BG;
        TransformGroup TG;
        public Dotyka (TransformGroup TG, BranchGroup BG, Sphere shape){
            dotyka_b = 0;
            this.TG= TG;
            this.BG = BG;
            this.shape=shape;
             setSchedulingBounds(new BoundingSphere(new Point3d(0.0f, 0.0f, 0.0f), 1000.0));
        }
        @Override
        public void initialize() {
            wakeupOn(new WakeupOnCollisionEntry(shape));
            dotyka_b=2;
        }
        @Override
        public void processStimulus(Enumeration enumeration) {
            if(dotyka_b == 1) {
                wakeupOn(new WakeupOnCollisionExit(shape));
                System.out.println("Dotyka!");
                dotyka_b = 0;
                dotyka_latch=true;
            }
            else if (dotyka_b == 0){
                wakeupOn(new WakeupOnCollisionEntry(shape));
                dotyka_b = 1;
                dotyka_latch=false;
                System.out.println("Nie dotyka!!");
            } else if (dotyka_b == 2 ) {
                wakeupOn(new WakeupOnCollisionExit(shape));
                dotyka_latch=true;
                dotyka_b = 0;
            }
        }
    }

    // funkcja odpowiadająca za to, co wyświetla się w programie
    public BranchGroup tworzScene(){

        TransformGroup obrot_animacja = new TransformGroup();
        obrot_animacja.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        TransformGroup obrot_animacja_kulka = new TransformGroup();
        obrot_animacja_kulka.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        wezel_2.addChild(obrot_animacja);
        wezel_3_kulka.addChild(obrot_animacja_kulka);

        alpha_animacja = new Alpha(-1,1000);
        Transform3D tmp = new Transform3D();
        tmp.set(new Vector3f(0.0f,-0.22f,0.0f));
        obracacz = new RotationInterpolator(alpha_animacja, obrot_animacja, tmp, 0, 0);


        alpha_animacja_kulka = new Alpha(-1,1000);
        Transform3D tmp_kulka = new Transform3D();
        tmp_kulka.set(new Vector3f(0.0f,-0.22f,0.0f));
        obracacz_kulka = new RotationInterpolator(alpha_animacja, obrot_animacja_kulka, tmp, 0, 0);

        Appearance wyglad_podstawy = new Appearance();

        BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), 10);

        obracacz.setSchedulingBounds(bounds);
        obrot_animacja.addChild(obracacz);

        obracacz_kulka.setSchedulingBounds(bounds);
        obrot_animacja.addChild(obracacz_kulka);

        // wprowadzenie podstawy robota
        Material pudelkow = new Material();
        pudelkow.setShininess(50f);
        pudelkow.setDiffuseColor(0.9f,0.3f,0.3f);
        pudelkow.setSpecularColor(0.2f, 0.1f, 0.1f);
        pudelkow.setEmissiveColor(0.0f, 0.5f, 0.1f);

        wyglad_podstawy.setMaterial(pudelkow);

        Transform3D przes_podstawy = new Transform3D();
        przes_podstawy.set(new Vector3f(0.0f, -0.63f,0.0f));
        TransformGroup podstawa = new TransformGroup(przes_podstawy);

        //dla kulki
        Transform3D przes_podstawy_kulka = new Transform3D();
        przes_podstawy_kulka.set(new Vector3f(0.0f, -0.63f,0.0f));

        Box pudlo = new Box(0.12f, 0.022f, 0.12f, Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS, wyglad_podstawy);
        podstawa.addChild(pudlo);
        wezel_scena.addChild(podstawa);

        // wprowadzenie wiezy robota, obracającej się wokół własnej osi
        TransformGroup wieza = new TransformGroup();
        Transform3D przes_wiezy = new Transform3D();
        przes_wiezy.set(new Vector3f(0.0f,-0.22f,0.0f));
        wieza.setTransform(przes_wiezy);

        //dla kulki
        TransformGroup wieza_kulka = new TransformGroup();
        Transform3D przes_wiezy_kulka = new Transform3D();
        przes_wiezy_kulka.set(new Vector3f(0.0f,-0.22f,0.0f));
        wieza_kulka.setTransform(przes_wiezy);

        Cylinder walec = new Cylinder(0.07f, 0.8f);
        wieza.addChild(walec);
        obrot_animacja.addChild(wieza);
        obrot_animacja.addChild(pozycja_ramie);

        //dla kulki

        obrot_animacja_kulka.addChild(wieza_kulka);
        obrot_animacja_kulka.addChild(pozycja_ramie_kulka);

        // pierwsze ramię, przesuwające się wzdłuż osi Z
        Transform3D przes_ramie = new Transform3D();
        przes_ramie.set(new Vector3f(0.3f, -0.15f, 0.0f));
        pozycja_ramie.setTransform(przes_ramie);
        pozycja_ramie.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        //dla kulki
        Transform3D przes_ramie_kulka = new Transform3D();
        przes_ramie_kulka.set(new Vector3f(-0.8f, 0.05f, 0.0f));
        pozycja_ramie_kulka.setTransform(przes_ramie_kulka);
        pozycja_ramie_kulka.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        Box ramie1 = new Box(0.5f, 0.027f, 0.12f, Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS, wyglad_podstawy);
        pozycja_ramie.addChild(ramie1);

        //wprowadzenie dalszej części robota, oś Y robota
        TransformGroup ramie_wys = new TransformGroup();
        Transform3D przes_ramie2 = new Transform3D();
        przes_ramie2.set(new Vector3f(0.6f,0f,0.0f));
        Transform3D tmp_rot = new Transform3D();
        tmp_rot.rotZ(-Math.PI/2);
        przes_ramie2.mul(tmp_rot);
        ramie_wys.setTransform(przes_ramie2);
        ramie_wys.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        pozycja_ramie2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        Cylinder ramie22 = new Cylinder(0.026f,0.8f);
        ramie_wys.addChild(ramie22);
        pozycja_ramie2.addChild(ramie_wys);
        pozycja_ramie.addChild(pozycja_ramie2);
        wezel_scena.addChild(wezel_2);

        //dla kulki
        TransformGroup ramie_wys_kulka = new TransformGroup();
        Transform3D przes_ramie2_kulka = new Transform3D();
        przes_ramie2_kulka.set(new Vector3f(0.6f,0f,0.0f));
        Transform3D tmp_rot_kulka = new Transform3D();
        tmp_rot_kulka.rotZ(-Math.PI/2);
        przes_ramie2.mul(tmp_rot_kulka);
        ramie_wys_kulka.setTransform(przes_ramie2_kulka);
        ramie_wys_kulka.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        pozycja_ramie2_kulka.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        ramie_wys_kulka.addChild(TG_B);
        pozycja_ramie2_kulka.addChild(ramie_wys_kulka);
        pozycja_ramie_kulka.addChild(pozycja_ramie2_kulka);
        wezel_scena.addChild(wezel_3_kulka);

        //swiatla
        Color3f kolor_swiatla= new Color3f(1f, 1f, 1f);
        Vector3f kierunek_swiatla_kier = new Vector3f(1f, -2f, 1f);

        AmbientLight swiatlo_tla1 = new AmbientLight(kolor_swiatla);
        AmbientLight swiatlo_tla2 = new AmbientLight(kolor_swiatla);
        DirectionalLight swiatlo_kier1 = new DirectionalLight(kolor_swiatla, kierunek_swiatla_kier);
        DirectionalLight swiatlo_kier2 = new DirectionalLight(kolor_swiatla, kierunek_swiatla_kier);
        SpotLight swiatlo_sto1 = new SpotLight(kolor_swiatla, new Point3f(5f, 2f, 0f), new Point3f(0.05f, 0.05f, 0.05f), new Vector3f(-0.5f, -0.2f, 0.0f),1.59f,1f);
        SpotLight swiatlo_sto2 = new SpotLight(kolor_swiatla, new Point3f(-5f, 2f, 1f), new Point3f(0.05f, 0.05f, 0.05f), new Vector3f(0.5f, -0.2f, -0.1f),1.59f,1f);

        swiatlo_tla1.setInfluencingBounds(bounds);
        swiatlo_kier1.setInfluencingBounds(bounds);
        swiatlo_sto1.setInfluencingBounds(bounds);
        swiatlo_sto1.setInfluencingBounds(bounds);

        wezel_scena.addChild(swiatlo_tla1);
        wezel_scena.addChild(swiatlo_kier1);
        wezel_scena.addChild(swiatlo_kier2);
        wezel_scena.addChild(swiatlo_tla2);
        wezel_scena.addChild(swiatlo_sto1);
        wezel_scena.addChild(swiatlo_sto2);


        //załadowanie tekstur pomieszczenia
        TextureLoader loader = new TextureLoader("drewno.jpg", null);
        ImageComponent2D image = loader.getImage();

        Texture2D sciany = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
        sciany.setImage(0, image);
        sciany.setBoundaryModeS(Texture.WRAP);
        sciany.setBoundaryModeT(Texture.WRAP);

        loader = new TextureLoader("podloga.jpg", null);
        image = loader.getImage();

        Texture2D podlog = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
        podlog.setImage(0, image);
        podlog.setBoundaryModeS(Texture.WRAP);
        podlog.setBoundaryModeT(Texture.WRAP);

        loader = new TextureLoader("sufit.jpg", null);
        image = loader.getImage();

        Texture2D sufi = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
        sufi.setImage(0, image);
        sufi.setBoundaryModeS(Texture.WRAP);
        sufi.setBoundaryModeT(Texture.WRAP);

        Appearance wyglad_scian = new Appearance();
        wyglad_scian.setTexture(sciany);

        Appearance wyglad_podloga = new Appearance();
        wyglad_podloga.setTexture(podlog);

        Appearance wyglad_sufit = new Appearance();
        wyglad_sufit.setTexture(sufi);

        Box hala = new Box(5.5f, 2f, 0.05f, Box.GENERATE_NORMALS_INWARD | Box.GENERATE_TEXTURE_COORDS, wyglad_scian);
        Box hala1 = new Box(5.5f, 2f, 0.05f, Box.GENERATE_TEXTURE_COORDS | Box.GENERATE_NORMALS_INWARD, wyglad_scian);
        Box hala2 = new Box(0.05f, 2f, 5.5f, Box.GENERATE_TEXTURE_COORDS | Box.GENERATE_NORMALS_INWARD, wyglad_scian);
        Box hala3 = new Box(0.05f, 2f, 5.5f, Box.GENERATE_TEXTURE_COORDS | Box.GENERATE_NORMALS_INWARD, wyglad_scian);
        Box podloga = new Box(5.5f, 0.05f, 5.5f, Box.GENERATE_TEXTURE_COORDS | Box.GENERATE_NORMALS_INWARD, wyglad_sufit);
        Box sufit = new Box(5.5f, 0.05f, 5.5f, Box.GENERATE_TEXTURE_COORDS | Box.GENERATE_NORMALS_INWARD, wyglad_podloga);

        //ustawienie tekstur w odpowiednich miejscach
        Transform3D p_hali = new Transform3D();
        p_hali.set(new Vector3f(0f, 1.35f, -5.50f));
        Transform3D p_hali1 = new Transform3D();
        p_hali1.set(new Vector3f(0f, 1.35f, +5.50f));
        Transform3D p_hali2 = new Transform3D();
        p_hali2.set(new Vector3f(-5.50f, 1.35f, 0f));
        Transform3D p_hali3 = new Transform3D();
        p_hali3.set(new Vector3f(5.50f, 1.35f, 0f));

        Transform3D p_pod = new Transform3D();
        p_pod.set(new Vector3f(0f, 3f, 0f));

        Transform3D p_suf = new Transform3D();
        p_suf.set(new Vector3f(0f, -0.7f, 0f));

        TransformGroup t_hali = new TransformGroup(p_hali);
        TransformGroup t_hali1 = new TransformGroup(p_hali1);
        TransformGroup t_hali2 = new TransformGroup(p_hali2);
        TransformGroup t_hali3 = new TransformGroup(p_hali3);
        TransformGroup t_pod = new TransformGroup(p_pod);
        TransformGroup t_suf = new TransformGroup(p_suf);

        t_hali.addChild(hala);
        t_hali1.addChild(hala1);
        t_hali2.addChild(hala2);
        t_hali3.addChild(hala3);
        t_pod.addChild(podloga);
        t_suf.addChild(sufit);
        wezel_scena.addChild(t_hali);
        wezel_scena.addChild(t_hali1);
        wezel_scena.addChild(t_hali2);
        wezel_scena.addChild(t_hali3);
        wezel_scena.addChild(t_pod);
        wezel_scena.addChild(t_suf);


        //kuleczka do podnoszenia przez robota
        Appearance wyglad_kuleczki = new Appearance();
        Material material2 = new Material(new Color3f(0.8f, 0.1f,0.3f), new Color3f(0.0f,0.0f,0.0f), new Color3f(0.1f,0.5f,0.1f), new Color3f(0.1f,0.1f,0.6f), 200);
        wyglad_kuleczki.setMaterial(material2);
        kuleczka = new Sphere(0.05f, Sphere.GENERATE_NORMALS,200, wyglad_kuleczki);
        Transform3D pos1 = new Transform3D();
        pos1.setTranslation(new Vector3f(1.4f, -0.5f, 0.0f));
        TransformGroup kulka = new TransformGroup();
        kulka.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        kulka.setTransform(pos1);
        kulka.addChild(kuleczka);
        TG_k = new TransformGroup();
        TG_k.addChild(kulka);
        TG_B.addChild(TG_k);

        //koncowka robota - manipulator
        Appearance wyglad_koncowki = new Appearance();
        Material material3 = new Material(new Color3f(0.8f, 0.6f,0.6f), new Color3f(0.0f,0.0f,0.0f), new Color3f(0.1f,0.5f,0.1f), new Color3f(0.1f,0.1f,0.6f), 200);
        wyglad_koncowki.setMaterial(material3);
        koncowka = new Sphere(0.05f, Sphere.GENERATE_NORMALS,200, wyglad_koncowki);
        Transform3D pos2 = new Transform3D();
        pos2.setTranslation(new Vector3f(0.0f, 0.43f, 0.0f));
        koncowka_p = new TransformGroup();
        koncowka_p.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        koncowka_p.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        koncowka_p.setTransform(pos2);
        koncowka_p.addChild(koncowka);
        ramie22.addChild(koncowka_p);

        dot = new Dotyka(TG_k, wezel_scena, kuleczka);

        wezel_scena.addChild(dot);
        return wezel_scena;
    }



    //funkcja do tworzenia sceny wraz z możliwością swobodnego obracania
    untitled(){
        setLayout(new BorderLayout());
        canvas3D.setPreferredSize(new Dimension(1280, 960));
        canvas3D.addKeyListener(this);
        add(BorderLayout.CENTER, canvas3D);

        setVisible(true);

        scena = tworzScene();
        scena.compile();
        panel.setBackground(Color.GRAY);
        add("North", panel);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        ViewingPlatform viewingPlatform = simpleU.getViewingPlatform();

        PlatformGeometry pg = new PlatformGeometry();

        viewingPlatform.setPlatformGeometry(pg);
        viewingPlatform.setNominalViewingTransform();

        //swobodne obracanie widoku w programie
        OrbitBehavior orbit = new OrbitBehavior(canvas3D, OrbitBehavior.REVERSE_ROTATE | OrbitBehavior.STOP_ZOOM);
        orbit.setReverseTranslate(true);
        orbit.setMinRadius(1.0);
        orbit.setRotationCenter(new Point3d(0.0f, -0.5f, 0.0f));
        orbit.setRotFactors(0.4, 0.4);
        orbit.setTransFactors(0.25, 0.25);
        orbit.setZoomFactor(0.25);
        orbit.setSchedulingBounds(bounds);
        viewingPlatform.setViewPlatformBehavior(orbit);

        simpleU.getViewer().getView().setMinimumFrameCycleTime(5);

        kamera.set(domyslna_kamera);
        simpleU.getViewingPlatform().getViewPlatformTransform().setTransform(kamera);
        simpleU.addBranchGraph(scena);
    }


    // funkcja odpowiedzialna za wciskanie odpowiedniego przycisku na klawiaturze
    @Override
    public void keyPressed(KeyEvent e) {
        // włączenie muzyki
        if (e.getKeyCode() == KeyEvent.VK_M)
            muzyka();

        // ustawienie domyślnej kamery w programie
        if (e.getKeyCode() == KeyEvent.VK_R) {
            kamera.set(domyslna_kamera);
            simpleU.getViewingPlatform().getViewPlatformTransform().setTransform(kamera);
        }

        // włączenie nagrywania
        if (e.getKeyCode() == KeyEvent.VK_N) {
            if (!nagrywanie && !odtwarzanie) {
                nagrywanie = true;
                panel.N.setBackground(Color.GREEN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_T) { // włączenie odtwarzania nagranych ruchów
            if (nagrywanie && !odtwarzanie)
                    nagrywanie = false;
                    odtwarzanie = true;
                    panel.N.setBackground(Color.WHITE);
        }

        // zmiana parametru związanego z obrotem wraz z blokadą
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (a > -2.5)
                a -= 0.01f;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (a < 2.5)
                a += 0.01f;
        }

        // zmiana parametru osi Z robota wraz z blokadą
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (b < 0.13)
                b += 0.01f;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (b > -0.56)
                b -= 0.01f;
        }

        // zmiana parametru osi Y robota wraz z blokadą
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            if (c < 0.29)
                c += 0.01f;
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            if (c > -0.47)
                c -= 0.01f;
        }

        // wciśnięcie przycisku na klawiaturze uruchamia zegar
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_E|| e.getKeyCode() == KeyEvent.VK_V || e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_N || e.getKeyCode() == KeyEvent.VK_T) {
            zegar = new java.util.Timer();
            zegar.scheduleAtFixedRate(new Ruch_robota(), 0, 50); //przyspieszone
        }

        // złapanie kulki
        if (e.getKeyCode() == KeyEvent.VK_C) {
            if (!zablokuj && dotyka_latch) {
                zablokuj = true;

            }
        }
        // wypuszczenie kulki
        if (e.getKeyCode() == KeyEvent.VK_V) {
            if (zablokuj) {
                zablokuj = false;

            }
        }

        // reset pozycji robota do domyślnej
        if (e.getKeyCode() == KeyEvent.VK_P) {
            a = 0;
            b = -0.15f;
            c = 0;
            zablokuj = false;
            zegar = new java.util.Timer();
            zegar.scheduleAtFixedRate(new Ruch_robota(), 0, 50);
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
    }
    @Override
    public void keyTyped(KeyEvent e){
    }

    public static void main(String[] args){
        Frame unti = new MainFrame(new untitled(), 1280, 760 );
        unti.setTitle("Robot cylindryczny");
        unti.setVisible(true);
    }
}