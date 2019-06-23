/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Armando
 */
public class Menu extends javax.swing.JFrame {

    int level = 0;
    int vidas = 0;
    int intentos = 0;
    int asiertos = 0;
    int operacion = 0;
    //String operaciones = "";
    String operador = "";
    String result = "";
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        //inicializar();
        //elements();
        inicializarLabs();
        audio();
        frameOperaciones.setResizable(false);
        frameOperaciones.setLocationRelativeTo(this);
        frameEmergente.setResizable(false);
        frameEmergente.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    public void audio(){
        
        try {
            
            // Se obtiene un Clip de sonido
            Clip sonido = AudioSystem.getClip();
            
            // Se carga con un fichero wav
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/offlikmits.wav"))));
            
            // Comienza la reproducción
            sonido.start();
            
            // Espera mientras se esté reproduciendo.
            while (sonido.isRunning())
                Thread.sleep(1000);
            
            // Se cierra el clip.
            //sonido.close();
            
            sonido.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    
    public void inicializar(){
        
        level = 1;
        vidas = 3;
        intentos = 0;
        asiertos = 0;
    }
    
    public void inicializarLabs(){
        
        labPersonaje.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/superpapermario31.jpg")));
        labPersona.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/superpapermario51.png")));
    }
    
    public void tiempoRespuesta(String respuesta){
        
        Timer timer;
        timer = new Timer();
        final String str = new String("REACHED TEN TICS");

        TimerTask task = new TimerTask() {
            int tic = 0;

            @Override
            public void run()
            {
                if (tic%2==0)
                    labRespuesta.setText(respuesta);
                else{
                    labRespuesta.setText("");
                    timer.cancel();
                }
                tic++;
                
            }
            };

        timer.schedule(task, 0, 1000);
    }
    
    public void animacion(String nombre){
        
        Timer timer2;
        timer2 = new Timer();
        final String str = new String("REACHED TEN TICS");
       
        TimerTask task = new TimerTask() {
            int tic = 0;
            
            @Override
            public void run()
            {
                if (tic%2==0)
                    labPersonaje.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/"+nombre+".png")));
                else{
                    labPersonaje.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/superpapermario31.jpg")));
                    timer2.cancel();
                }
                tic++;
                
            }
            };

        timer2.schedule(task, 0, 1000);
        
    }
    
    public void elements(){
        
        int numero = 0;
        int numero1 = 0;
        int resultado = 0;
        int nBoton = 0;
        String nivel = "Nivel " + level;
        String lives = "Vidas " + vidas;
        String asierto = asiertos + " / 50";
        operaciones objOperacion = new operaciones();
        
        numero = (int)(Math.random()*10+2*level);
        numero1 = (int)(Math.random()*10+2*level);
        
        labLevel.setText(nivel);
        labVidas.setText(lives);
        labAsiertos.setText(asierto);
        labOperadores.setText(operador);
        labNumeroup.setText(Integer.toString( numero ));
        labNumerodown.setText(Integer.toString( numero1));
        
        if(operador.equals("+")){
            resultado = objOperacion.suma(numero, numero1);
        }else if(operador.equals("-")){
            resultado = objOperacion.resta(numero, numero1);
            }else if(operador.equals("*")){
                resultado = objOperacion.multiplicacion(numero, numero1);  
            }
        
        this.result = Integer.toString(resultado);
        nBoton = (int)(Math.random()*8+1);
        
        if((vidas > 0) && (level <= 10)){

            if(boton1.getName().equals("boton"+Integer.toString(nBoton))){

                boton1.setText(Integer.toString(resultado));
            }else{

                boton1.setText(Integer.toString((int)(Math.random()*15+operacion*level)));  
            }

            if(boton2.getName().equals("boton"+Integer.toString(nBoton))){

                boton2.setText(Integer.toString(resultado));
            }else{

                boton2.setText(Integer.toString((int)(Math.random()*15+operacion*level)));         

            }

            if(boton3.getName().equals("boton"+Integer.toString(nBoton))){

                boton3.setText(Integer.toString(resultado));
            }else{

                boton3.setText(Integer.toString((int)(Math.random()*15+operacion*level)));            

            }

            if(boton4.getName().equals("boton"+Integer.toString(nBoton))){

                boton4.setText(Integer.toString(resultado));
            }else{

                boton4.setText(Integer.toString((int)(Math.random()*15+operacion*level)));           

            }

            if(boton5.getName().equals("boton"+Integer.toString(nBoton))){

                boton5.setText(Integer.toString(resultado));
            }else{

                boton5.setText(Integer.toString((int)(Math.random()*15+operacion*level)));            

            }

            if(boton6.getName().equals("boton"+Integer.toString(nBoton))){

                boton6.setText(Integer.toString(resultado));
            }else{

                boton6.setText(Integer.toString((int)(Math.random()*15+operacion*level)));            

            }

            if(boton7.getName().equals("boton"+Integer.toString(nBoton))){

                boton7.setText(Integer.toString(resultado));
            }else{

                boton7.setText(Integer.toString((int)(Math.random()*15+operacion*level)));            

            }

            if(boton8.getName().equals("boton"+Integer.toString(nBoton))){

                boton8.setText(Integer.toString(resultado));
            }else{

                boton8.setText(Integer.toString((int)(Math.random()*15+operacion*level)));            

            }
        }else{
            if(vidas==0){
                try {
                Clip sonido = AudioSystem.getClip();
                sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/marioohno.wav"))));
                sonido.start();
                } catch (Exception e) {
                    System.out.println("" + e);
                }
                labPersonaje.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/superpapermario61.png")));
                labEmergente.setText("Has Perdido deceas continuar jugando?");
                frameEmergente.setVisible(true);
                
            }else{
                if(level > 10){
                    labEmergente.setText("Felicidades Ganaste!! \n Deceas continuar jugando?");
                    frameEmergente.setVisible(true);
                }
            }
        }
        //boton1.setText(Integer.toString(resultado));
        
        //labResultado.setText( Integer.toString(resultado));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameOperaciones = new javax.swing.JFrame();
        panelmenu = new javax.swing.JPanel();
        labOperacion = new javax.swing.JLabel();
        labPersonaje = new javax.swing.JLabel();
        labOperadores = new javax.swing.JLabel();
        labNumeroup = new javax.swing.JLabel();
        labNumerodown = new javax.swing.JLabel();
        labResultado = new javax.swing.JLabel();
        labRespuesta = new javax.swing.JLabel();
        labAsiertos = new javax.swing.JLabel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        labVidas = new javax.swing.JLabel();
        labLevel = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        frameEmergente = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        labEmergente = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        labafondo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labPersona = new javax.swing.JLabel();
        btnMultiplicacion = new javax.swing.JButton();
        btnResta = new javax.swing.JButton();
        btnSuma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        frameOperaciones.setSize(new java.awt.Dimension(950, 720));

        panelmenu.setBackground(new java.awt.Color(40, 168, 234));
        panelmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labOperacion.setFont(new java.awt.Font("Super Mario Bros.", 1, 30)); // NOI18N
        labOperacion.setForeground(new java.awt.Color(255, 255, 255));
        panelmenu.add(labOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 330, 50));
        panelmenu.add(labPersonaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 190, 210));

        labOperadores.setFont(new java.awt.Font("Super Mario Bros.", 1, 36)); // NOI18N
        labOperadores.setForeground(new java.awt.Color(255, 255, 255));
        panelmenu.add(labOperadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 70, 40));

        labNumeroup.setFont(new java.awt.Font("Super Mario Bros.", 1, 36)); // NOI18N
        labNumeroup.setForeground(new java.awt.Color(255, 255, 255));
        panelmenu.add(labNumeroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 70, 40));

        labNumerodown.setFont(new java.awt.Font("Super Mario Bros.", 1, 36)); // NOI18N
        labNumerodown.setForeground(new java.awt.Color(255, 255, 255));
        panelmenu.add(labNumerodown, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 70, 40));

        labResultado.setFont(new java.awt.Font("Super Mario Bros.", 1, 36)); // NOI18N
        labResultado.setForeground(new java.awt.Color(255, 255, 255));
        panelmenu.add(labResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 70, 40));

        labRespuesta.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
        panelmenu.add(labRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 170, 50));

        labAsiertos.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        labAsiertos.setForeground(new java.awt.Color(51, 51, 51));
        panelmenu.add(labAsiertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 120, 50));

        boton1.setBackground(new java.awt.Color(12, 12, 12));
        boton1.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton1.setForeground(new java.awt.Color(255, 255, 255));
        boton1.setName("boton1"); // NOI18N
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        panelmenu.add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, 70, 60));

        boton2.setBackground(new java.awt.Color(12, 12, 12));
        boton2.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton2.setForeground(new java.awt.Color(255, 255, 255));
        boton2.setName("boton2"); // NOI18N
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        panelmenu.add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 620, 70, 60));

        boton3.setBackground(new java.awt.Color(12, 12, 12));
        boton3.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton3.setForeground(new java.awt.Color(255, 255, 255));
        boton3.setName("boton3"); // NOI18N
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        panelmenu.add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, 70, 60));

        boton4.setBackground(new java.awt.Color(12, 12, 12));
        boton4.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton4.setForeground(new java.awt.Color(255, 255, 255));
        boton4.setName("boton4"); // NOI18N
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        panelmenu.add(boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 70, 60));

        boton5.setBackground(new java.awt.Color(12, 12, 12));
        boton5.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton5.setForeground(new java.awt.Color(255, 255, 255));
        boton5.setName("boton5"); // NOI18N
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });
        panelmenu.add(boton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, 70, 60));

        boton6.setBackground(new java.awt.Color(12, 12, 12));
        boton6.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton6.setForeground(new java.awt.Color(255, 255, 255));
        boton6.setName("boton6"); // NOI18N
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });
        panelmenu.add(boton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 70, 60));

        boton7.setBackground(new java.awt.Color(12, 12, 12));
        boton7.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton7.setForeground(new java.awt.Color(255, 255, 255));
        boton7.setName("boton7"); // NOI18N
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });
        panelmenu.add(boton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, 70, 60));

        boton8.setBackground(new java.awt.Color(12, 12, 12));
        boton8.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        boton8.setForeground(new java.awt.Color(255, 255, 255));
        boton8.setName("boton8"); // NOI18N
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });
        panelmenu.add(boton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 70, 60));

        labVidas.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        labVidas.setForeground(new java.awt.Color(12, 12, 12));
        panelmenu.add(labVidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 130, 50));

        labLevel.setFont(new java.awt.Font("Super Mario Bros.", 1, 24)); // NOI18N
        labLevel.setForeground(new java.awt.Color(12, 12, 12));
        panelmenu.add(labLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 130, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        panelmenu.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 700));

        javax.swing.GroupLayout frameOperacionesLayout = new javax.swing.GroupLayout(frameOperaciones.getContentPane());
        frameOperaciones.getContentPane().setLayout(frameOperacionesLayout);
        frameOperacionesLayout.setHorizontalGroup(
            frameOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frameOperacionesLayout.setVerticalGroup(
            frameOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frameEmergente.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frameEmergente.setAlwaysOnTop(true);
        frameEmergente.setSize(new java.awt.Dimension(549, 200));

        jPanel3.setBackground(new java.awt.Color(45, 70, 110));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(440, 173));
        jPanel3.setMinimumSize(new java.awt.Dimension(440, 173));
        jPanel3.setPreferredSize(new java.awt.Dimension(440, 173));
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labEmergente.setBackground(new java.awt.Color(255, 255, 255));
        labEmergente.setFont(new java.awt.Font("Nintend", 3, 18)); // NOI18N
        labEmergente.setForeground(new java.awt.Color(255, 255, 0));
        labEmergente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(labEmergente, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 21, 494, 69));

        btnContinuar.setBackground(new java.awt.Color(153, 255, 153));
        btnContinuar.setForeground(new java.awt.Color(12, 12, 12));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel3.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 116, 39));

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setForeground(new java.awt.Color(12, 12, 12));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 116, 39));

        labafondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/patronevectores.png"))); // NOI18N
        jPanel3.add(labafondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 180));

        javax.swing.GroupLayout frameEmergenteLayout = new javax.swing.GroupLayout(frameEmergente.getContentPane());
        frameEmergente.getContentPane().setLayout(frameEmergenteLayout);
        frameEmergenteLayout.setHorizontalGroup(
            frameEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );
        frameEmergenteLayout.setVerticalGroup(
            frameEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AprendeMatematicas");
        setMaximumSize(new java.awt.Dimension(620, 335));
        setMinimumSize(new java.awt.Dimension(620, 335));
        setSize(new java.awt.Dimension(620, 335));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(labPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 210, 240));

        btnMultiplicacion.setBackground(new java.awt.Color(45, 70, 110));
        btnMultiplicacion.setFont(new java.awt.Font("Super Mario Bros.", 1, 18)); // NOI18N
        btnMultiplicacion.setForeground(new java.awt.Color(255, 255, 255));
        btnMultiplicacion.setText("Multiplicacion");
        btnMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnMultiplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 230, 50));

        btnResta.setBackground(new java.awt.Color(45, 70, 110));
        btnResta.setFont(new java.awt.Font("Super Mario Bros.", 1, 18)); // NOI18N
        btnResta.setForeground(new java.awt.Color(255, 255, 255));
        btnResta.setText("Resta");
        btnResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaActionPerformed(evt);
            }
        });
        jPanel1.add(btnResta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 230, 50));

        btnSuma.setBackground(new java.awt.Color(45, 70, 110));
        btnSuma.setFont(new java.awt.Font("Super Mario Bros.", 1, 18)); // NOI18N
        btnSuma.setForeground(new java.awt.Color(255, 255, 255));
        btnSuma.setText("Suma");
        btnSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interioraulaescuela.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        // TODO add your handling code here:
        
        String valor = boton3.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        // TODO add your handling code here:
        String valor = boton4.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
        String valor = boton2.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
        String valor = boton1.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        // TODO add your handling code here:
        String valor = boton8.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        // TODO add your handling code here:
        String valor = boton7.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        // TODO add your handling code here:
        String valor = boton6.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        // TODO add your handling code here:
        String valor = boton5.getText();
        System.out.println(valor);
        System.out.println(result);
        if (valor.equals(this.result)){
            
            intentos += 1;
            asiertos += 1;
            
            if(intentos == 5){
                
                level += 1;
                intentos = 0;
            }
            labRespuesta.setForeground(new java.awt.Color(153, 255, 153));
            tiempoRespuesta("Correcto!");
            animacion("superpapermario21");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshineyahoo.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }else{
            vidas -= 1;
            labRespuesta.setForeground(new java.awt.Color(220, 76, 64));
            tiempoRespuesta("Incorrecto!");
            animacion("superpapermario41");
            try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream((this.getClass().getResource("/music/smsunshinehorror.wav"))));
            sonido.start();
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        
        elements();
    }//GEN-LAST:event_boton5ActionPerformed

    private void btnSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumaActionPerformed
        // TODO add your handling code here:
        operador = "+";
        operacion = 2;
        inicializar();
        elements();
        labOperacion.setText("Suma");
        frameOperaciones.setVisible(true);
    }//GEN-LAST:event_btnSumaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        frameOperaciones.dispose();
        frameEmergente.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        frameEmergente.dispose();
        inicializar();
        elements();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaActionPerformed
        // TODO add your handling code here:
        operador = "-";
        operacion = -2;
        inicializar();
        elements();
        labOperacion.setText("Resta");
        frameOperaciones.setVisible(true);
    }//GEN-LAST:event_btnRestaActionPerformed

    private void btnMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicacionActionPerformed
        // TODO add your handling code here:
        operador = "*";
        operacion = 10;
        inicializar();
        elements();
        labOperacion.setText("Multiplicacion");
        frameOperaciones.setVisible(true);
    }//GEN-LAST:event_btnMultiplicacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnMultiplicacion;
    private javax.swing.JButton btnResta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSuma;
    private javax.swing.JLabel fondo;
    private javax.swing.JFrame frameEmergente;
    private javax.swing.JFrame frameOperaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labAsiertos;
    private javax.swing.JLabel labEmergente;
    private javax.swing.JLabel labLevel;
    private javax.swing.JLabel labNumerodown;
    private javax.swing.JLabel labNumeroup;
    private javax.swing.JLabel labOperacion;
    private javax.swing.JLabel labOperadores;
    private javax.swing.JLabel labPersona;
    private javax.swing.JLabel labPersonaje;
    private javax.swing.JLabel labRespuesta;
    private javax.swing.JLabel labResultado;
    private javax.swing.JLabel labVidas;
    private javax.swing.JLabel labafondo;
    private javax.swing.JPanel panelmenu;
    // End of variables declaration//GEN-END:variables
}
