package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAimWave extends AttackSkill {
    public FinalAimWave() {
        this.setName("파이널 에임(파동)");
        this.setAttackCount(7L);            // 에디셔널 볼트
        this.setCooldown(360.0);
        this.setDamage(7800.0);
        this.setDotDuration(6400L);
        this.setLimitAttackCount(8L);
        this.setInterval(800L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FinalAimArrow());
    }
}
