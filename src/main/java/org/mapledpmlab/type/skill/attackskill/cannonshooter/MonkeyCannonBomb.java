package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyCannonBomb extends AttackSkill {
    public MonkeyCannonBomb() {
        this.setName("스페셜 몽키 에스코트(폭발의 카키-몽키 캐논)");
        this.setDamage(660.0);
        this.setAttackCount(4L);
        this.setDotDuration(35000L);
        this.setInterval(2500L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new MonkeyCannonRapidFire());
    }
}
