package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossomSecretApricotTreePlumBlossom40 extends AttackSkill {
    public PlumBlossomSecretApricotTreePlumBlossom40() {
        this.setName("매화검 절기 : 만리향(매화꽃 40개)");
        this.setAttackCount(3L);
        this.setDamage(500.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.getMultiAttackInfo().add(450L);
        for (int i = 0; i < 39; i++) {
            this.getMultiAttackInfo().add(0L);
        }
    }
}
