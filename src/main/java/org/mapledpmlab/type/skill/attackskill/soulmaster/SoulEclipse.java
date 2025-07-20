package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulEclipse extends AttackSkill {
    public SoulEclipse() {
        this.setName("소울 이클립스");
        this.setDelayByAttackSpeed(360L);
        this.setAttackCount(7L);
        this.setDamage(635.0);
        this.setCooldown(120.0);
        this.setDotDuration(20000L);
        this.setInterval(470L);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(1.6);       // 코어강화
    }
}
