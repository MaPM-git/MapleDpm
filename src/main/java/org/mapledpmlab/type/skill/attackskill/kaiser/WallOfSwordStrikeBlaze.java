package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WallOfSwordStrikeBlaze extends AttackSkill {
    public WallOfSwordStrikeBlaze() {
        this.setName("윌 오브 소드 : 스트라이크(불길)");
        this.setDamage(2200.0);
        this.setAttackCount(5L * 6);
        this.getMultiAttackInfo().add(3500L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
