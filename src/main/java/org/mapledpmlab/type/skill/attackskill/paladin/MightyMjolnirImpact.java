package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MightyMjolnirImpact extends AttackSkill {
    public MightyMjolnirImpact() {
        this.setName("마이티 묠니르(충격파)");
        this.setAttackCount(9L);
        this.setDamage(605.0);
        this.setFinalDamage(1.6);   // 코어 강화
    }
}
