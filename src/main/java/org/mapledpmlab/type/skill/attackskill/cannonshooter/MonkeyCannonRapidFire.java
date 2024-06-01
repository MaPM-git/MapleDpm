package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyCannonRapidFire extends AttackSkill {
    public MonkeyCannonRapidFire() {
        this.setName("스페셜 몽키 에스코트(속사의 맥시-몽키 캐논)");
        this.setDamage(660.0);
        this.setAttackCount(4L);
        /*this.setDotDuration(35000L);
        this.setInterval(700L);*/
        this.addFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(2400L + 1200);
        for (int i = 0; i < 42; i++) {
            this.getMultiAttackInfo().add(700L);
        }
    }
}
