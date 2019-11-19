/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class clsFirma {

    private byte[][] seed;
    private int[] ultH;
    private int[] H;
    private byte[][] ultSeed;

    private byte[][] link;
    private byte[][] ultFirma;
    private byte[][] firma;
    private byte[][] llave;

    public clsFirma() {
    }

    public clsFirma(byte[][] s, byte[][] us, int[] uh, byte[][] uf) {
        //seed=s;
        ultSeed = us;
        ultH = uh;
        ultFirma = uf;

    }

    public int[] getH() {
        return H.clone();
    }

    public void setUltH(int[] ultH) {
        this.ultH = ultH;
    }

    public byte[][] getSeed() {
        return seed.clone();
    }

    public int[] getUltH() {
        return ultH.clone();
    }

    public byte[][] getUltSeed() {
        return ultSeed.clone();
    }

    public byte[][] getLink() {
        return link.clone();
    }

    public byte[][] getUltFirma() {
        return ultFirma.clone();
    }

    public byte[][] getFirma() {
        return firma.clone();
    }

    public byte[][] getLlave() {
        return llave.clone();
    }

    //Firma un numero aleatorio para la creacion de la primer cadena
    public void iniciarNuevo() throws IOException {
        this.seed = genSemillas();
        this.ultSeed = getSeed();

        byte[] m0 = Double.toString(Math.random() * Math.pow(2, 32)).getBytes();
        this.ultH = calcH(m0);
        FirmarIn(m0);

    }

    private byte[] calcHash(byte[] x) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(clsFirma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digest.digest(x);
    }

    private int toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    private byte[][] genSemillas2() {
        byte[][] s = new byte[16][32];
        for (int i = 0; i < 16; i++) {
            s[i] = Double.toString(Math.random() * Math.pow(2, 32)).getBytes();
        }
        return s;
    }

    private byte[][] genSemillas() throws IOException {

        BigInteger s0 = new BigInteger(255, new Random());
        byte[][] s = new byte[16][32];
        s[0] = (new BigInteger(255, new Random())).toByteArray();
        s[1] = (new BigInteger(255, new Random())).toByteArray();

        for (int i = 2; i < 16; i++) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            output.write(s[i - 2]);
            output.write(s[i - 1]);
            s[i] = calcHash(output.toByteArray());
        }
        return s;
    }

    public byte[][] calcLlave() {
        byte[][] l = new byte[16][32];

        for (int i = 0; i < 16; i++) {
            l[i] = cadena(seed[i]);
        }
        return l;
    }

    public byte[] cadena(byte[] s) {
        double n = Math.pow(2, 16);
        for (int i = 0; i < n; i++) {
            s = calcHash(s);
        }
        return s;
    }

    private int[] calcH(byte[] mensaje) {
        byte[] m = calcHash(mensaje);
        int[] h = new int[16];
        for (int i = 0; i < 16; i++) {
            byte[] aux = {0, 0, m[i * 2], m[i * 2 + 1]};
            h[i] = toDouble(aux);
        }

        return h;
    }

    public byte[][] FirmarIn(byte[] mensaje) {

        int[] h = calcH(mensaje);
        ultFirma = this.getSeed();

        for (int i = 0; i < 16; i++) {
            int p = (int) Math.pow(2, 16) - h[i];
            for (int j = 0; j < p; j++) {
                ultFirma[i] = calcHash(ultFirma[i]);
            }
        }

        return getUltFirma();
    }

    public String Firmar(byte[] m) throws IOException {
        //generar firma
        seed = genSemillas();
        llave = calcLlave();

        firma = getSeed();
        int[] h = calcH(m);
        H = h.clone();
        for (int i = 0; i < 16; i++) {
            int p = (int) Math.pow(2, 16) - h[i];
            for (int j = 0; j < p; j++) {
                firma[i] = calcHash(firma[i]);
            }
        }

        //calcular mapeo de firma
        link = getUltSeed();
        for (int i = 0; i < 16; i++) {

            int dx = (h[i] - BigInteger.valueOf(ultH[i]).multiply(BigInteger.valueOf(h[i])).divide(BigInteger.valueOf((long) (Math.pow(2, 16) - 1))).intValue());
            int e = (int) Math.ceil((Math.pow(2, 16) - ultH[i] - dx));

            for (int j = 0; j < e; j++) {
                link[i] = calcHash(link[i]);
            }
        }

        String informacion = depurar(m);
        return informacion;

    }

    public String depurar(byte[] mensaje) {
        String inf = "";
        int[] h = calcH(mensaje);
        String[] firmaA = this.getFirmaHex().split(",");
        String[] linkA = this.getLinkHex().split(",");
        String[] llavePA = this.getLlaveHex().split(",");

        System.out.println(" 2n: " + (int) Math.pow(2, 16));
        inf += "2n: " + (int) Math.pow(2, 16) + "\n";

        for (int i = 0; i < 16; i++) {

            int dx = (h[i] - BigInteger.valueOf(ultH[i]).multiply(BigInteger.valueOf(h[i])).divide(BigInteger.valueOf((long) (Math.pow(2, 16) - 1))).intValue());
            int e = (int) Math.ceil((Math.pow(2, 16) - ultH[i] - dx));

            //int e=(int)(h[i]-((ultH[i]*h[i])/(Math.pow(2, 16)-1)));
            //double dx=(h[i]-((ultH[i]*h[i])/((Math.pow(2, 16)-1))));
            System.out.println(i + " f0: " + (int) (Math.pow(2, 16) - ultH[i]));
            System.out.println(i + " e: " + e);
            System.out.println(i + " h0: " + ultH[i]);
            System.out.println(i + " h1: " + h[i]);
            System.out.println(i + " dx: " + dx + "\n");

            inf += "i= " + i + "\n";
            inf += "\th0: " + ultH[i] + "\n";
            inf += "\th1: " + h[i] + "\n";
            inf += "\tf0: " + (int) (Math.pow(2, 16) - ultH[i]) + "\n";
            inf += "\te: " + e + "\n";
            inf += "\tdx: " + dx + "\n";
            inf += "\tfirma: " + firmaA[i] + "\n";
            inf += "\tlink: " + linkA[i] + "\n";
            inf += "\tllave: " + llavePA[i] + "\n";

//            for (int j = 0; j < e; j++) {
//                aux[i] = calcHash(aux[i]);
//            }
        }

//        for (int i = 0; i < 16; i++) {
//
//            if (toDouble(aux[i]) == toDouble(ultFirma[i])) {
//                //System.out.println("\nCorrectoP");
//            } else {
//                System.out.println("\n" + i + " MalP\t ");
//                int e = (int) Math.ceil((Math.pow(2, 16) - ultH[i] - h[i] + ((ultH[i] * h[i]) / ((Math.pow(2, 16) - 1)))));
//                int e2 = (int) (h[i] - ((ultH[i] * h[i]) / (Math.pow(2, 16) - 1)));
//                int p = (int) (Math.pow(2, 16) - ultH[i]);
//                System.out.println("f0:" + p);
//                System.out.println("se:" + (e2 + e));
//                System.out.println("r1:" + (e2));
//
//            }
//        }
        return inf;
    }

    public byte[][] verificarFirma(byte[][] f1, byte[][] f0, int[] uh, byte[] mensaje) {
        int[] h = calcH(mensaje);
        firma = f1;

        long t = System.currentTimeMillis();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < h[i]; j++) {
                firma[i] = calcHash(firma[i]);
            }
        }
        t = System.currentTimeMillis() - t;
        System.out.println("Tiempo de Primera verificacion: " + t);
        t = System.currentTimeMillis();

        link = f0;
        for (int i = 0; i < 16; i++) {
            int e = (h[i] - BigInteger.valueOf(uh[i]).multiply(BigInteger.valueOf(h[i])).divide(BigInteger.valueOf((long) (Math.pow(2, 16) - 1))).intValue());

            //int e=(int)(h[i]-((uh[i]*h[i])/(Math.pow(2, 16)-1)));
            for (int j = 0; j < e; j++) {
                link[i] = calcHash(link[i]);
            }
        }
        t = System.currentTimeMillis() - t;
        System.out.println("Tiempo de segunda verificacion: " + t);
        return firma;
    }

    public String getUltFirmaHex() {
        String hfirma = "";
        for (byte[] f : this.ultFirma) {
            hfirma += byteToHex(f) + ",";
        }
        hfirma = hfirma.substring(0, hfirma.length() - 1);

        return hfirma;

    }

    public String[] getUltSeedHex() {
        String semilla[] = new String[2];
        semilla[0] = byteToHex(this.ultSeed[0]);
        semilla[1] = byteToHex(this.ultSeed[1]);
        return semilla;
    }

    public String getFirmaHex() {
        String hfirma = "";
        for (byte[] f : this.firma) {
            hfirma += byteToHex(f) + ",";
        }
        hfirma = hfirma.substring(0, hfirma.length() - 1);

        return hfirma;

    }

    public String getLinkHex() {
        String hfirma = "";
        for (byte[] f : this.link) {
            hfirma += byteToHex(f) + ",";
        }
        hfirma = hfirma.substring(0, hfirma.length() - 1);

        return hfirma;

    }

    public String getLlaveHex() {
        String hfirma = "";
        for (byte[] f : this.llave) {
            hfirma += byteToHex(f) + ",";
        }
        hfirma = hfirma.substring(0, hfirma.length() - 1);
        return hfirma;
    }

    public void setUltSeedHex(String s0, String s1) throws IOException {

        byte[][] s = new byte[16][32];
        s[0] = hextoByte(s0);
        s[1] = hextoByte(s1);

        for (int i = 2; i < 16; i++) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            output.write(s[i - 2]);
            output.write(s[i - 1]);
            s[i] = calcHash(output.toByteArray());
        }
        this.ultSeed = s.clone();

    }

    private String byteToHex(byte[] f) {
        String hex = "";
        for (byte b : f) {
            String st = String.format("%02x", b);
            hex += st;
        }
        return hex;
    }

    public static byte[] hextoByte(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

}
