/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt;

import java.awt.*;

public class Klawisze extends javax.swing.JPanel {


    public Klawisze() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        W = new javax.swing.JButton();
        A = new javax.swing.JButton();
        S = new javax.swing.JButton();
        R = new javax.swing.JButton();
        R_opis = new javax.swing.JLabel();
        P_opis = new javax.swing.JLabel();
        Obrot = new javax.swing.JLabel();
        Os_Z = new javax.swing.JLabel();
        D = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        Os_Y = new javax.swing.JLabel();
        E = new javax.swing.JButton();
        P = new javax.swing.JButton();
        M = new javax.swing.JButton();
        N = new javax.swing.JButton();
        T = new javax.swing.JButton();
        N_opis = new javax.swing.JLabel();
        T_opis = new javax.swing.JLabel();
        C = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        C_opis = new javax.swing.JLabel();
        Z_opis = new javax.swing.JLabel();
        M_opis = new javax.swing.JLabel();

        //setForeground(java.awt.Color.white);

        W.setBackground(new java.awt.Color(255, 255, 255));
        W.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        W.setForeground(new java.awt.Color(0, 0, 0));
        W.setText("W");
        W.setEnabled(false);
        W.setPreferredSize(new java.awt.Dimension(50, 50));

        A.setBackground(new java.awt.Color(255, 255, 255));
        A.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        A.setForeground(new java.awt.Color(0, 0, 0));
        A.setText("A");
        A.setEnabled(false);
        A.setPreferredSize(new java.awt.Dimension(50, 50));


        S.setBackground(new Color(255, 255, 255));
        S.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        S.setText("S");
        S.setEnabled(false);
        S.setPreferredSize(new java.awt.Dimension(50, 50));

        R.setBackground(new java.awt.Color(255, 255, 255));
        R.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        R.setForeground(Color.black);
        R.setText("R");
        R.setEnabled(false);
        R.setPreferredSize(new java.awt.Dimension(50, 50));

        R_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        R_opis.setText("Resetowanie kamery");

        P_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        P_opis.setText("Resetowanie robota");

        Obrot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Obrot.setText("Obrót robota");

        Os_Z.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Os_Z.setText("Oś Z robota");

        D.setBackground(new java.awt.Color(255, 255, 255));
        D.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        D.setForeground(java.awt.Color.white);
        D.setText("D");
        D.setEnabled(false);
        D.setPreferredSize(new java.awt.Dimension(50, 50));

        Q.setBackground(new java.awt.Color(255, 255, 255));
        Q.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        Q.setForeground(java.awt.Color.white);
        Q.setText("Q");
        Q.setEnabled(false);
        Q.setPreferredSize(new java.awt.Dimension(50, 50));

        Os_Y.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Os_Y.setText("Oś Y robota");

        E.setBackground(new java.awt.Color(255, 255, 255));
        E.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        E.setForeground(java.awt.Color.white);
        E.setText("E");
        E.setEnabled(false);
        E.setPreferredSize(new java.awt.Dimension(50, 50));

        P.setBackground(new java.awt.Color(255, 255, 255));
        P.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        P.setForeground(java.awt.Color.white);
        P.setText("P");
        P.setEnabled(false);
        P.setPreferredSize(new java.awt.Dimension(50, 50));

        M.setBackground(new java.awt.Color(255, 255, 255));
        M.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        M.setForeground(java.awt.Color.white);
        M.setText("M");
        M.setEnabled(false);
        M.setPreferredSize(new java.awt.Dimension(50, 50));

        N.setBackground(new java.awt.Color(255, 255, 255));
        N.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        N.setForeground(java.awt.Color.white);
        N.setText("N");
        N.setEnabled(false);
        N.setPreferredSize(new java.awt.Dimension(50, 50));

        T.setBackground(new java.awt.Color(255, 255, 255));
        T.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        T.setForeground(java.awt.Color.white);
        T.setText("T");
        T.setEnabled(false);
        T.setPreferredSize(new java.awt.Dimension(50, 50));

        N_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        N_opis.setText("Nagrywanie trajektorii");

        T_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        T_opis.setText("Odtwarzanie trajektorii");

        C.setBackground(new java.awt.Color(255, 255, 255));
        C.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        C.setForeground(java.awt.Color.white);
        C.setText("C");
        C.setEnabled(false);
        C.setPreferredSize(new java.awt.Dimension(50, 50));

        Z.setBackground(new java.awt.Color(255, 255, 255));
        Z.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        Z.setForeground(java.awt.Color.white);
        Z.setText("V");
        Z.setEnabled(false);
        Z.setPreferredSize(new java.awt.Dimension(50, 50));

        C_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        C_opis.setText("Łapanie kulki");

        Z_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Z_opis.setText("Puszczenie kulki");

        M_opis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        M_opis.setText("Włączenie muzyki");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Obrot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Os_Z)
                        .addGap(24, 24, 24)
                        .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Os_Y))
                    .addComponent(M_opis))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R_opis)
                    .addComponent(P_opis))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(T_opis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Z_opis))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(N_opis)
                        .addGap(18, 18, 18)
                        .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(C_opis)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Obrot)
                    .addComponent(Os_Y)
                    .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_opis)
                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N_opis)
                    .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_opis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Os_Z)
                    .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_opis)
                    .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_opis)
                    .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Z_opis)
                    .addComponent(M_opis)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton A;
    public javax.swing.JButton C;
    private javax.swing.JLabel C_opis;
    public javax.swing.JButton D;
    public javax.swing.JButton E;
    public javax.swing.JButton M;
    private javax.swing.JLabel M_opis;
    public javax.swing.JButton N;
    private javax.swing.JLabel N_opis;
    private javax.swing.JLabel Obrot;
    private javax.swing.JLabel Os_Y;
    private javax.swing.JLabel Os_Z;
    public javax.swing.JButton P;
    private javax.swing.JLabel P_opis;
    public javax.swing.JButton Q;
    public javax.swing.JButton R;
    private javax.swing.JLabel R_opis;
    public javax.swing.JButton S;
    public javax.swing.JButton T;
    private javax.swing.JLabel T_opis;
    public javax.swing.JButton W;
    public javax.swing.JButton Z;
    private javax.swing.JLabel Z_opis;
    // End of variables declaration//GEN-END:variables
}
