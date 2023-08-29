package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulEclipse extends AttackSkill {
    public SoulEclipse() {
        this.setName("소울 이클립스");
        this.setAttackCount(7L * 2);
        this.setDamage(990.0);
        this.setCooldown(180.0);
        this.setDotDuration(40000L);
        this.setInterval(1000L);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new SoulEclipseDelay());
    }
}
