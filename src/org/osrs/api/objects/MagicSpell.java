package org.osrs.api.objects;

import org.osrs.api.methods.MethodContext;
import org.osrs.api.methods.Skills;

public class MagicSpell {
	private MethodContext methods;
	public String name;
	public int level;
	public double experience;
	private RSWidget widget;
	private int varbitValue;
	public MagicSpell(MethodContext context, String spellName, int lvl, double exp, int varpbit){
		methods = context;
		name = spellName;
		level = lvl;
		experience = exp;
		varbitValue = varpbit;
	}
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public boolean hasLevel(){
		return methods.skills.getSkillLevel(Skills.MAGIC_INDEX)>=level;
	}
	public int getVarbitID(){
		return varbitValue;
	}
	/*
	 * In the case of combat spells (such as wind strike),
	 * experience is base experience; additional experience
	 * will be gained from damage dealt from spell.
	 */
	public double getExperience(){
		return experience;
	}
	public boolean isSelected(){
		RSWidget w = getWidget();
		if(w!=null){
			return w.borderThickness()==2;
		}
		return false;
	}
	public boolean isDisplayed(){
		RSWidget w = getWidget();
		if(w!=null){
			return w.isDisplayed();
		}
		return false;
	}
	public boolean isVisible(){
		RSWidget w = getWidget();
		if(w!=null){
			return w.isVisible();
		}
		return false;
	}
	public boolean isHovering(){
		RSWidget w = getWidget();
		if(w!=null){
			return w.isHovering();
		}
		return false;
	}
	public boolean click(){
		RSWidget w = getWidget();
		if(w!=null){
			return w.click();
		}
		return false;
	}
	public boolean click(String action){
		RSWidget w = getWidget();
		if(w!=null){
			return w.click(action);
		}
		return false;
	}
	public boolean click(String action, String option){
		RSWidget w = getWidget();
		if(w!=null){
			return w.click(action, option);
		}
		return false;
	}
	public boolean hover(){
		RSWidget w = getWidget();
		if(w!=null){
			return w.hover();
		}
		return false;
	}
	public boolean hover(String action){
		RSWidget w = getWidget();
		if(w!=null){
			return w.hover(action);
		}
		return false;
	}
	public boolean hover(String action, String option){
		RSWidget w = getWidget();
		if(w!=null){
			return w.hover(action, option);
		}
		return false;
	}
	public RSWidget getWidget(){
		if(widget!=null){
			if(widget.isDisplayed())
				return widget;
		}
		for(RSInterface iface : methods.widgets.getAll()){
			if(iface!=null){
				for(RSWidget w : iface.getChildren()){
					if(w!=null){
						if(w.isDisplayed()){
							if(w.opbase().equals("<col=00ff00>"+name+"</col>")){
								widget = w; 
								return widget;
							}
						}
					}
					for(RSWidget w2 : w.getChildren()){
						if(w2!=null){
							if(w2.isDisplayed()){
								if(w2.containsAction(name)){
									widget = w2;
									return widget;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
