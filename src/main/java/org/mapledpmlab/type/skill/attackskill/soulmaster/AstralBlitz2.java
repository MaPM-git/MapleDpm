package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AstralBlitz2 extends AttackSkill {
    public AstralBlitz2() {
        this.setName("아스트랄 블리츠(태초의 폭발)");
        this.setAttackCount(7L * 2);
        this.setDamage(9900.0);
        this.setDotDuration(390L * 5);
        this.setInterval(390L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.setRelatedSkill(new AstralBlitzDelay());
    }
}
