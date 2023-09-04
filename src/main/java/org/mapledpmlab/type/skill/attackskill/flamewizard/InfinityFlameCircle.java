package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfinityFlameCircle extends AttackSkill {
    public InfinityFlameCircle() {
        this.setName("인피니티 플레임 서클");
        this.setDamage(1210.0);
        this.setAttackCount(8L);
        this.setCooldown(108.0);
        this.setDotDuration(9000L);
        this.setInterval(120L);
        this.setLimitAttackCount(76L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new InfinityFlameCircleDelay());
    }
}
