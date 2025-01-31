package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StormWhim extends AttackSkill {
    public StormWhim() {
        this.setName("스톰 윔");
        this.setAttackCount(1L);
        this.setDamage(935.0);
        this.setProp(30L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
