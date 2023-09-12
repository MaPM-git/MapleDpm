package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RavenousBatReinforce extends AttackSkill implements DarkAttack {
    public RavenousBatReinforce() {
        this.setName("강화 래버너스 배트");
        this.setFinalAttack(true);
        this.setAttackCount(3L);
        this.setDamage(485.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
