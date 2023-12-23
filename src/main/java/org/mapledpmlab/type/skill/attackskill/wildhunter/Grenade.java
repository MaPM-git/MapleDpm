package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Grenade extends AttackSkill {
    public Grenade() {
        this.setName("유탄");
        this.setDotDuration(10000L);
        this.setInterval(1200L);
        this.setDamage(415.0);
        this.setAttackCount(4L);
        this.setRelatedSkill(new GrenadeBoom());
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
        this.setAddDamage(20L + 20);    // 와일드 발칸-리인포스, 보스 킬러
    }
}
