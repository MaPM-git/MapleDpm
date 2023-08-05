package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAimArrow extends AttackSkill {
    public FinalAimArrow() {
        this.setName("파이널 에임(화살)");
        this.setAttackCount(14L);           // 에디셔널 볼트
        this.setCooldown(360.0);
        this.setDamage(11940.0);
        this.setDotDuration(1580L);
        this.setLimitAttackCount(5L);
        this.setInterval(316L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FinalAimDelay());
    }
}
