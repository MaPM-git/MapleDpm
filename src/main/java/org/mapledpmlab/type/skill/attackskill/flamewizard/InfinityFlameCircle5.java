package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfinityFlameCircle5 extends AttackSkill {
    public InfinityFlameCircle5() {
        this.setName("인피니티 플레임 서클(5스택)");
        this.setDamage(1210.0);
        this.setDelay(120L * 42 + 540);
        this.setAttackCount(8L);
        this.setDotDuration(120L * 42);
        this.setInterval(120L);
        this.setLimitAttackCount(42L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
