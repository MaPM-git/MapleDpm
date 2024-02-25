package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.eunwol.AdventOfTheFoxBuff;

public class AdventOfTheFox extends AttackSkill {
    public AdventOfTheFox() {
        this.setName("호신강림");
        this.setAttackCount(12L);
        this.setCooldown(360.0);
        this.setDamage(960.0);
        this.setDelay(4020L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new AdventOfTheFoxBuff());
        this.getMultiAttackInfo().add(1500L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(1140L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
