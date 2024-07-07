package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackCaptain extends AttackSkill {
    public FinalAttackCaptain() {
        this.setName("파이널 어택(캡틴)");
        this.setAttackCount(1L);
        this.setDamage(278.0 + 145);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.addFinalDamage(1.3);       // 전함 노틸러스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
