package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WallOfSwordStrike extends AttackSkill {
    public WallOfSwordStrike() {
        this.setName("윌 오브 소드 : 스트라이크");
        this.setDamage(1100.0);
        this.setAttackCount(5L * 4);
        this.setCooldown(30.0);
        this.getMultiAttackInfo().add(1500L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new WallOfSwordStrikeBlaze());
    }
}
