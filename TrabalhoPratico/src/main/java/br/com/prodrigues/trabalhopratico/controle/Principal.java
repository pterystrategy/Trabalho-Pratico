/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.prodrigues.trabalhopratico.controle;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author alessio
 */

public class Principal {

    public static void main(String[] args) {
        
        PrincipalControle principal = new PrincipalControle();
        principal.iniciar();
////            EntityManagerFactory emf;
////            EntityManager em;
////            
////            emf = Persistence.createEntityManagerFactory("trabalhoPraticoPU");
////            em = emf.createEntityManager();
    }
    
}
