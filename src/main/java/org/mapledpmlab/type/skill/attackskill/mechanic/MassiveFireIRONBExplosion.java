package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MassiveFireIRONBExplosion extends AttackSkill {
    public MassiveFireIRONBExplosion() {
        this.setName("매시브 파이어 : IRON-B(2차 폭발)");
        this.setAttackCount(3L);
        this.setDamage(390.0 + 160);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L);                 // 매시브 파이어-리인포스
    }
}
