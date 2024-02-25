package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.evan.ZodiacBurstBuff;

public class ZodiacBurst extends AttackSkill {
    public ZodiacBurst() {
        this.setName("조디악 버스트");
        this.setDamage(1120.0);
        this.setAttackCount(15L);
        this.setDelay(3180L);
        this.setRelatedSkill(new ZodiacBurstBuff());
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);     // 8
        this.getMultiAttackInfo().add(1740L);
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
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
