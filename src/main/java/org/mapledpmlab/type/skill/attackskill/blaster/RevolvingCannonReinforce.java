package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RevolvingCannonReinforce extends AttackSkill {
    public RevolvingCannonReinforce() {
        this.setName("리볼빙 캐논(강화)");
        this.setAttackCount(8L);
        this.setDamage(550.0);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
