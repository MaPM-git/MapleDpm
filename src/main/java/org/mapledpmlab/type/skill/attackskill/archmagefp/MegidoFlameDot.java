package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class MegidoFlameDot extends DotAttackSkill {
    public MegidoFlameDot() {
        this.setName("메기도 플레임(도트)");
        this.setDamage(700.0);
        this.setAttackCount(1L);
        this.setDotDuration(60000L);    // 익스트림 매직
        this.setInterval(1000L);
        this.setRelatedSkill(new MegidoFlameAfterSecond());
    }
}
