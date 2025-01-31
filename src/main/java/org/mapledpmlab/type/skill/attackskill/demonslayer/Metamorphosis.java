package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Metamorphosis extends AttackSkill {
    public Metamorphosis() {
        this.setName("메타모포시스");
        this.setAttackCount(4L);
        this.setDamage(1090.0);
        this.setCooldown(1.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 메타모포시스-리인포스
    }
}
