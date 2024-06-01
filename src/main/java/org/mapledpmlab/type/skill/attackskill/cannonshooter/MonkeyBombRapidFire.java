package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyBombRapidFire extends AttackSkill {
    public MonkeyBombRapidFire() {
        this.setName("스페셜 몽키 에스코트(속사의 맥시-몽키 봄)");
        this.setDamage(990.0);
        this.setAttackCount(7L);
        this.setDotDuration(35000L);
        this.setInterval(30000L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new MonkeyCannonBasic());
        this.getMultiAttackInfo().add(2400L);
        this.getMultiAttackInfo().add(31320L);
    }
}
