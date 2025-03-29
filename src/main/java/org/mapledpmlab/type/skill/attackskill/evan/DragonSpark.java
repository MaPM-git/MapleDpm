package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonSpark extends AttackSkill {
    public DragonSpark() {
        this.setName("드래곤 스파킹");
        this.setAttackCount(1L);
        this.setDamage(555.0);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.setAddDamage(30L);
        this.addFinalDamage(2.8);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(30L);     // 아티팩트
    }
}
