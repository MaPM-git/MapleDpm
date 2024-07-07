package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BigStretch extends AttackSkill {
    public BigStretch() {
        this.setName("큰 기지개");
        this.setDamage(1320.0);
        this.setAttackCount(5L);
        this.setCooldown(60.0);
        this.setDelay(870L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(1980L);
        for (int i = 0; i < 34; i ++) {
            this.getMultiAttackInfo().add(90L);
        }
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
