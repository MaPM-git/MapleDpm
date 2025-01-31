package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DemonBane2 extends AttackSkill {
    public DemonBane2() {
        this.setName("데몬베인(마지막)");
        this.setDelay(1560L + 450);     // 막타 후딜레이
        this.setDotDuration(1560L);
        this.setInterval(120L);
        this.setLimitAttackCount(13L);
        this.setAttackCount(7L);
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(1375.0);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.9);       // 데몬 어웨이크닝
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
