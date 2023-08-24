package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyBombBomb extends AttackSkill {
    public MonkeyBombBomb() {
        this.setName("스페셜 몽키 에스코트(폭발의 카키-몽키 봄)");
        this.setDamage(990.0);
        this.setAttackCount(7L);
        this.setDotDuration(35000L);
        this.setInterval(3000L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new MonkeyBombRapidFire());
    }
}
