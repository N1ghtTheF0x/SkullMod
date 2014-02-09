package skullMod.lvlEdit.dataStructures.completeLevel;

import skullMod.lvlEdit.dataStructures.SGA.SGA_File;
import skullMod.lvlEdit.dataStructures.SGI.SGI_Element;
import skullMod.lvlEdit.dataStructures.SGI.SGI_File;
import skullMod.lvlEdit.dataStructures.SGM.SGM_File;
import skullMod.lvlEdit.dataStructures.jTreeNodes.NodeAdapter;

import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;

public class Models extends NodeAdapter {
    private final LinkedList<Model> models;

    public Models(TreeNode parent, Model[] models) {
        super(parent);

        //TODO verify input

        this.models = new LinkedList<>();

        for(Model model : models){
            this.models.add(model);
        }
    }

    public Models(TreeNode parent){
        super(parent);
        this.models = new LinkedList<>();
        this.models.add(new Model(this));
    }

    public Models(TreeNode parent, SGI_File sgiData, HashMap<String, SGM_File> models, HashMap<String, HashMap<String,SGA_File>> animations) {
        super(parent);

        this.models = new LinkedList<>();

        for(SGI_Element modelMetadata : sgiData.elements){
            this.models.add(new Model(this, modelMetadata, models.get(modelMetadata.elementName), animations.get(modelMetadata.elementName)));
        }
    }

    public String toString(){
        return "Models";
    }

    public int getChildCount() {
        return models.size();
    }

    public Enumeration children() {
        return Collections.enumeration(models);
    }
}