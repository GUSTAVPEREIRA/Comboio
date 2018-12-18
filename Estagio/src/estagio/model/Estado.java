/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagio.model;

/**
 *
 * @author Pereira
 */
public class Estado {
    private int est_id;
    private String est_uf;
    private String est_nome;

    public Estado() {
    }

    public Estado(int est_id, String est_uf, String est_nome) {
        this.est_id = est_id;
        this.est_uf = est_uf;
        this.est_nome = est_nome;
    }

    public int getEst_id() {
        return est_id;
    }

    public void setEst_id(int est_id) {
        this.est_id = est_id;
    }

    public String getEst_uf() {
        return est_uf;
    }

    public void setEst_uf(String est_uf) {
        this.est_uf = est_uf;
    }

    public String getEst_nome() {
        return est_nome;
    }

    public void setEst_nome(String est_nome) {
        this.est_nome = est_nome;
    }

    @Override
    public String toString() {
        return getEst_nome();
    }
    
    
    
}
