package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RoseCarteFinaleDot extends AttackSkill {
    public RoseCarteFinaleDot() {
        this.setName("로즈 카르트 피날레(도트)");
        this.setAttackCount(2L);
        this.setDamage(200.0);
        this.setDotDuration(8000L);
        this.setInterval(930L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
