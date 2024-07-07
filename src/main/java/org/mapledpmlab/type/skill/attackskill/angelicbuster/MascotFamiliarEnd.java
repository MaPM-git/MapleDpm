package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MascotFamiliarEnd extends AttackSkill {
    public MascotFamiliarEnd() {
        this.setName("마스코트 패밀리어(폭발)");
        this.setDelay(120L);
        this.setDamage(1485.0);
        this.setAttackCount(10L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
