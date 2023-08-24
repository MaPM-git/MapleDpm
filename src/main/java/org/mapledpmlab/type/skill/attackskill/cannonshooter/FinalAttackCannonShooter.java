package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackCannonShooter extends AttackSkill {
    public FinalAttackCannonShooter() {
        this.setName("파이널 어택(캐논 슈터)");
        this.setAttackCount(3L);        // 벅샷
        this.setDamage(175.0);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.addFinalDamage(0.45);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
