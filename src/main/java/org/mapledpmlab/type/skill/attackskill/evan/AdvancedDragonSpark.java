package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedDragonSpark extends AttackSkill {
    public AdvancedDragonSpark() {
        this.setName("어드밴스드 드래곤 스파킹");
        this.setAttackCount(1L);
        this.setDamage(150.0);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.8);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
