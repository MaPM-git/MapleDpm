package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SalamanderMischief extends AttackSkill {
    public SalamanderMischief(Long embers) {
        this.setName("샐리맨더 미스칩");
        this.setDamage(330.0);
        this.setDelay(750L);
        this.setAttackCount(7L);
        this.setCooldown(90.0);
        this.setDotDuration(60000L);
        this.setInterval(625L);
        this.setLimitAttackCount(96L);
        if (embers < 45) {
            this.setFinalDamage(1.0 + embers * 0.01);
        } else {
            this.setFinalDamage(1.45);
        }
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
