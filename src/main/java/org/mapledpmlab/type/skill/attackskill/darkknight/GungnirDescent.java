package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GungnirDescent extends AttackSkill {
    public GungnirDescent() {
        this.setName("궁니르 디센트");
        this.setDamage(390.0 + 145);    // 다크 신서시스 VI
        this.setAttackCount(12L);
        this.setAddDamage(30L);         // 궁니르 디센트-리인포스, 보스킬러
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(40L);
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
