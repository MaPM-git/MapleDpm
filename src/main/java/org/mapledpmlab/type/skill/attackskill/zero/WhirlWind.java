package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WhirlWind extends AttackSkill implements BetaSkill {
    public WhirlWind() {
        this.setName("휠 윈드");
        this.setDelayByAttackSpeed(60L);
    }
}
