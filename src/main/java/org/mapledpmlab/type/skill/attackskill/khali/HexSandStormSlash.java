package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexSandStormSlash extends AttackSkill implements HexSkill {
    public HexSandStormSlash() {
        this.setName("헥스 : 샌드스톰(참격)");
        this.setAttackCount(10L);
        this.setDamage(830.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setDelay(1770L);
        this.setRelatedSkill(new HexSandStormBomb());
        this.getMultiAttackInfo().add(720L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(300L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
