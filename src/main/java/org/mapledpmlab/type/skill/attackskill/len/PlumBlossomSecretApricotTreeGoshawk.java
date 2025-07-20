package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossomSecretApricotTreeGoshawk extends AttackSkill {
    public PlumBlossomSecretApricotTreeGoshawk() {
        this.setName("매화검 절기 : 만리향(참매)");
        this.setAttackCount(3L);
        this.setDamage(280.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
