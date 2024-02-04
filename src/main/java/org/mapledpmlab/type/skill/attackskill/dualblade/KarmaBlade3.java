package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaBlade3 extends AttackSkill {
    public KarmaBlade3() {
        this.setName("카르마 블레이드(업보의 칼날)");
        this.setAttackCount(7L);
        this.setDamage(857.0);
        this.setCooldown(0.1);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
