package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SylphidiaRush extends AttackSkill {
    public SylphidiaRush() {
        this.setName("실피디아(돌진)");
        this.setAttackCount(9L);
        this.setDamage(1430.0);
        this.setDelay(690L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
