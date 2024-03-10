package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GrandisGoddessBlessingLef extends BuffSkill {
    public GrandisGoddessBlessingLef(Long att) {
        this.setName("그란디스 여신의 축복");
        this.setCooldown(0.0);  // 스택형이라 딜사이클에서 따로 처리
        this.setDelay(630L);
        this.setDuration(40L);
        this.addBuffAttMagic(100L + att);
    }
}
