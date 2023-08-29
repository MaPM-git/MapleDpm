package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AstralBlitz1 extends AttackSkill {
    public AstralBlitz1() {
        this.setName("아스트랄 블리츠(참격)");
        this.setAttackCount(5L * 2);
        this.setDamage(7200.0);
        this.setCooldown(360.0);
        this.setDotDuration(390L * 14);
        this.setInterval(390L);
        this.setLimitAttackCount(14L);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.setRelatedSkill(new AstralBlitz2());
    }
}
