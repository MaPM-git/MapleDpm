package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HomingMissile extends AttackSkill {
    public HomingMissile() {
        this.setName("호밍 미사일");
        this.setAttackCount(4L + 5 + 1 + 1);
        this.setDamage(500.0);
        this.addFinalDamage(0.6);               // 메탈아머 : 탱크
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setInterval(660L);
    }
}
