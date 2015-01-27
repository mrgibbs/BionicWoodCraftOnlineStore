/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers;
/**
 *
 * @author mrgibbs
 */
public class PathBarElement {
    private String label;
    private String link;
    private String labelUkr;

    public String getLabelUkr() {
        return labelUkr;
    }

    public void setLabelUkr(String labelUkr) {
        this.labelUkr = labelUkr;
    }

    public PathBarElement(String label, String link) {
        this.label = label;
        this.link = link;
    }

    public PathBarElement() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
