package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlashAssault extends AttackSkill implements AlphaSkill {
    public FlashAssault() {
        this.setName("플래시 어썰터");
        this.setAttackCount(8L);
        this.setDamage(165.0);
        this.setDelayByAttackSpeed(630L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
