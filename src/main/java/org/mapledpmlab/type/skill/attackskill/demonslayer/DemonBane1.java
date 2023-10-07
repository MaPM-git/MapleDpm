package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DemonBane1 extends AttackSkill {
    public DemonBane1() {
        this.setName("데몬베인(키다운)");
        this.setDotDuration(2640L);
        this.setInterval(240L);
        this.setLimitAttackCount(11L);
        this.setAttackCount(6L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(580.0);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.9);       // 데몬 어웨이크닝
        this.setRelatedSkill(new DemonBane1Delay());
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
